//package com.taohui.readinglist;
//
//import org.hamcrest.Matchers;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.hamcrest.Matchers.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = ReadinglistApplication.class)
//@WebAppConfiguration
//public class unsecureTests {
//
//    @Autowired
//    private WebApplicationContext webContext;
//
//    private MockMvc mockMvc;
//
//    @Before
//    public void setupMockMvc(){
//        mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
//    }
//
//    @Test
//    public void homePage() throws Exception {
//        mockMvc.perform(get("/readingList/th"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("readingList"))
//                .andExpect(model().attributeExists("books"))
//                .andExpect(model().attribute("books", Matchers.is(Matchers.empty())));
//    }
//
//    @Test
//    public void postBook() throws Exception {
//        String book_title = "BOOK TITLE";
//        String book_author = "BOOK AUTHOR";
//        String book_isbn = "1234567890";
//        String book_description = "DESCRIPTION";
//        mockMvc.perform(post("/readingList/th")
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                .param("title", book_title)
//                .param("author", book_author)
//                .param("isbn", book_isbn)
//                .param("description", book_description))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(header().string("Location", "/readingList/th"));
//
//        Book expectedBook = new Book();
//        expectedBook.setTitle(book_title);
//        expectedBook.setAuthor(book_author);
//        expectedBook.setDescription(book_description);
//        expectedBook.setIsbn(book_isbn);
//        expectedBook.setReader("th");
//        expectedBook.setId(1L);
//
//        mockMvc.perform(get("/readingList/th"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("readingList"))
//                .andExpect(model().attributeExists("books"))
//                .andExpect(model().attribute("books", hasSize(1)))
//                .andExpect(model().attribute("books", contains(samePropertyValuesAs(expectedBook))));
//    }
//}
