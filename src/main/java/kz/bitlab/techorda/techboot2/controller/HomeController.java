package kz.bitlab.techorda.techboot2.controller;


import kz.bitlab.techorda.techboot2.db.ApplicationRequest;
import kz.bitlab.techorda.techboot2.db.DBManager;
import kz.bitlab.techorda.techboot2.dbconnect.ApplicationManager;
import kz.bitlab.techorda.techboot2.model.ApplicationModel;
import kz.bitlab.techorda.techboot2.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ApplicationManager manager;

    @Autowired
    private ApplicationRepository applicationRepository;

   @GetMapping(value = "/")
   public String indexPage(Model model){
       List<ApplicationModel> applicationModelList=applicationRepository.findAll();
       model.addAttribute("zayavky", applicationModelList);
       return "index";
   }

    @GetMapping(value = "/new")
    public String NewApplicationPage(Model model){
        List<ApplicationModel> applicationModelList=applicationRepository.findAll();
        model.addAttribute("zayavky", applicationModelList);
        return "newapplication";
    }

    @GetMapping(value = "/old")
    public String OldApplicationPage(Model model){
        List<ApplicationModel> applicationModelList=applicationRepository.findAll();
        model.addAttribute("zayavky", applicationModelList);
        return "oldapplication";
    }

   @PostMapping(value = "/add-zayavky")
    public String addApplicationRequest(ApplicationModel applicationRequest){
       applicationRepository.save(applicationRequest);
       return "redirect:/";
   }
   @GetMapping(value = "/addpage")
    public String addPage(){
       return "addpage";
   }

   @GetMapping(value = "/application-details")
    public String getApplication(@RequestParam(name = "id") Long id, Model model){
       ApplicationModel applicationRequest=applicationRepository.findById(id).orElse(null);
       model.addAttribute("zayavky", applicationRequest);
       return "details";
   }

   @PostMapping(value = "/save-zayavky")
    public String saveApplication(ApplicationModel applicationRequest){
       applicationRequest.setHandled(true);
       applicationRepository.save(applicationRequest);
       return "redirect:/";
   }

   @PostMapping(value = "/delete-application")
    public String deleteApplication(@RequestParam(name = "id") Long id){
       applicationRepository.deleteById(id);
       return "redirect:/";
   }



}
