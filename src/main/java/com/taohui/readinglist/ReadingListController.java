package com.taohui.readinglist;

import com.taohui.readinglist.Entity.Book;
import com.taohui.readinglist.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/readingList")
public class ReadingListController {
    private BookRepository bookRepository;
    private AmazonProperties amazonProperties;

    private static final String reader = "hui";

    @Autowired
    public ReadingListController(BookRepository bookRepository, AmazonProperties amazonProperties){
        this.bookRepository = bookRepository;
        this.amazonProperties = amazonProperties;
    }

    @GetMapping
    public String readersBooks(Model model){
        List<Book> books = bookRepository.findByReader(reader);
        if(books != null){
            model.addAttribute("books", books);
            model.addAttribute("reader", reader);
            model.addAttribute("amazonId", amazonProperties.getAssociateId());
        }
        return "readingList";
    }

    @PostMapping
    public String addToReadingList(Book book){
        book.setReader(reader);
        bookRepository.save(book);
        return "redirect:/readingList";
    }
}
