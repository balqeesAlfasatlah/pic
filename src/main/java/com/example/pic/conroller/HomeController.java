package com.example.pic.conroller;

import com.example.pic.models.CatPicture;
import com.example.pic.repository.PicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {

    @Autowired
    PicRepository picRepository;

    @GetMapping("/")
    public String adduser(){
        return "home";
    }

@PostMapping("/kittens")
    public RedirectView addCat(String name,String age , String img){
    CatPicture catPicture = new CatPicture(name, age, img);
    picRepository.save(catPicture);
    return new RedirectView("/index");
}

@GetMapping("/index")
    public String getCat(Model model){
    model.addAttribute("cats",picRepository.findAll());
    return "index";
}

@GetMapping("/edit/{id}")
public String showEditForm(@PathVariable("id") long id , Model model){
    model.addAttribute("cat",picRepository.findById(id));
    return "update-user";

}

@PostMapping("/update/{id}")
    public  RedirectView updatedValues(@PathVariable("id") long id, @ModelAttribute CatPicture catPicture ){
     picRepository.save(catPicture);
     return new RedirectView("/index");
}

@GetMapping("/delete/{id}")
    public RedirectView deleteCat(@PathVariable("id") long id , @ModelAttribute CatPicture catPicture ){
    picRepository.delete(catPicture);
    return new RedirectView("/index");
}




//+-
//    @GetMapping("/signup")
//    public String showSignUpForm(CatPicture catPicture) {
//        return "add-user";
//    }
//
//    @PostMapping("/adduser")
//    public String addUser(@ModelAttribute CatPicture catPicture) {
//        picRepository.save(catPicture);
//        return "redirect:/index";
//    }
//
//    @GetMapping("/index")
//    public String showUserList(Model model) {
//        model.addAttribute("cats", picRepository.findAll());
//        return "index";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String showUpdateForm(@PathVariable("id") long id, Model model) {
//        CatPicture catPicture = picRepository.findById(id);
//        model.addAttribute("catPicture", catPicture);
//        return "update-user";
//    }
//
//
//    @PostMapping("/update/{id}")
//    public String updateUser(@PathVariable("id") long id, @ModelAttribute CatPicture catPicture) {
//        picRepository.save(catPicture);
//        return "redirect:/index";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteUser(@PathVariable("id") long id) {
//        CatPicture catPicture  = picRepository.findById(id);
//        picRepository.delete(catPicture);
//        return "redirect:/index";
//    }























//    @PutMapping("/myCat/{id}/edit")
//    public String editCat(@ModelAttribute CatPicture catPicture , @PathVariable Long id){
//        personService.editPerson(person); //person has only the three fields filled in and all the other attributes as NULL
//        return "redirect:/person/" + personId;
//    }

//    @PutMapping("/myCat/{id}")
//    public String updateCat(@PathVariable Long id, Model model){
//        model.addAttribute("cats",picRepository.findById(id));
//        return "home.html";
//    }
























//   @PostMapping("/cats")
//    public RedirectView  addPic(String name , String age , String img){
//       //model.addAttribute("catPicture",catPicture);
//       CatPicture kitten = new CatPicture( name ,  age ,  img);
//       picRepository.save(kitten);
//       return new  RedirectView("/hi");
//
//   }
//
//   @GetMapping("/hi")
//    public String getPic(Model model){
//       model.addAttribute("balqees", picRepository.findAll());
//       return "home.html";
//   }
}
