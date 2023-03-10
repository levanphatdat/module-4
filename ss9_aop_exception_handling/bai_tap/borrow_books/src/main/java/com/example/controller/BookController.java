package com.example.controller;

import com.example.model.Book;
import com.example.model.Order;
import com.example.service.IBookService;
import com.example.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IOrderService orderService;

    @GetMapping("")
    public String list(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "/list";
    }

    @GetMapping("/{id}/order")
    public String order(@PathVariable int id, Model model) throws Exception {
        Order order = new Order();
        int code = (int) (Math.random() * (99999 - 10000) + 10000);
        order.setCode(code);
        String date = String.valueOf(new Date(System.currentTimeMillis()));
        order.setBorrowedDate(date);
        Book book = bookService.findById(id);
        book.setQuantity(book.getQuantity() - 1);
        if (book.getQuantity() == 0) {
            throw new Exception();
        }
        order.setBook(book);
        Set<Order> orders = book.getOrders();
        orders.add(order);
        book.setOrders(orders);
        bookService.create(book);
        orderService.create(order);
        return "redirect:/list";
    }

    @GetMapping("/orderList")
    public String orderList(Model model) {
        List<Order> orderList = orderService.findAll();
        model.addAttribute("orderList", orderList);
        return "/orderList";
    }

    @GetMapping("/{id}/payBook")
    public String payBookConfirm(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "/confirmPay";
    }

    @PostMapping("/payBook")
    public String payBook(@RequestParam int code, RedirectAttributes redirectAttributes) {
        Order order = orderService.findByCode(code);
        if (order == null) {
            redirectAttributes.addFlashAttribute("success", "Code error !!!");
        } else {
            orderService.delete(order);
            Book book = order.getBook();
            book.setQuantity(book.getQuantity() + 1);
            bookService.create(book);
        }
        return "redirect:/list";
    }

}
