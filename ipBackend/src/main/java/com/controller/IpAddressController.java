package com.controller;

import com.entity.IpAddress;
import com.service.IPAddressValidator;
import com.service.IpAddressService;
import com.service.StorageService;
import com.strorage.StorageFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/addresses")
public class IpAddressController {

    private final StorageService storageService;

    private IpAddressService ipAddressService;

    private IPAddressValidator validator;

    @Autowired
    public IpAddressController(StorageService storageService, IpAddressService ipAddressService, IPAddressValidator validator) {
        this.storageService = storageService;
        this.ipAddressService = ipAddressService;
        this.validator = validator;
    }

    @RequestMapping(value = "/remote",method = RequestMethod.GET)
    public Collection<IpAddress> getAllRemoteIpAddress(){
        return ipAddressService.getAllIpAddress();
    }

    @RequestMapping(value = "/remote", method = RequestMethod.POST)
    public void postIpAddress(){
        ipAddressService.postIpAddress(ipAddressService.getIpAddress());
    }

    @RequestMapping(value = "/local",method = RequestMethod.GET)
    public Collection<IpAddress> getAllIpAddress(){
        return ipAddressService.getAllLocalIpAddress();
    }

    @RequestMapping(value = "/local", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postLocalIpAddress(@RequestBody IpAddress ipAddress) {
        if(validator.validate(ipAddress.getIpAddress())) {
            ipAddressService.postLocalIpAddress(ipAddress);
        }
    }

    @GetMapping("/")
    public String listUpLoadedFiles(Model model) throws IOException{
        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(IpAddressController.class,
                        "serveFile", path.getFileName().toString()).build().toString())
                .collect(Collectors.toList()));
        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }



}