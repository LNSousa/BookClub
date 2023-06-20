package com.lsousa.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lsousa.bookclub.models.Book;
import com.lsousa.bookclub.services.BookService;
import com.lsousa.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("userId").equals(null)) {
			return "redirect:/";
		}
		
		model.addAttribute("userName", userService.getOne((Long) session.getAttribute("userId")).getName());
		model.addAttribute("books", bookService.getAll());
		return "dashboard.jsp";
	}
	
	@GetMapping("/books/new")
	public String createBook(@ModelAttribute("newBook") Book book, HttpSession session, Model model) {
		if(session.getAttribute("userId").equals(null)) {
			return "redirect:/";
		}
		
        return "newbook.jsp";
    }
	
	@GetMapping("/books/{id}")
	public String bookDetails(Model model, @PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userId").equals(null)) {
			return "redirect:/";
		}
		model.addAttribute("book", bookService.getOne(id));
		return "book.jsp";
	}
	
	@GetMapping("/books/{id}/edit")
	public String editBook(Model model, @PathVariable("id") Long id, HttpSession session) {
		model.addAttribute("book", bookService.getOne(id));
		if(!session.getAttribute("userId").equals(((Book) model.getAttribute("book")).getUser().getId())) {
			return "redirect:/books/" + id;
		}
		
		return "editbook.jsp";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		bookService.deleteOne(id);
		
		return "redirect:/";
	}
	
	@PostMapping("/books/new")
	public String newBook(@Valid @ModelAttribute("newBook") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "newbook.jsp";
		}
		
		bookService.save(book);
		return "redirect:/dashboard";
	}
	
	@PostMapping("/edit/{id}")
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("book", book);
			return "editbook.jsp";
		}
		
		Book editedBook = bookService.save(book);
		
		return "redirect:/books/" + editedBook.getId();
	}


}
