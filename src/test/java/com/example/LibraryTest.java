package com.example;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
public class LibraryTest {
        
    @Test
    public void testGetBook(){
        List<String> bookList1 =  Arrays.asList("Book1");
        Library lib = new Library();
        lib.addBook("Book1");
        List<String> bookList2 = lib.getBooks();
        assertTrue(bookList1.equals(bookList2));
    }

    //  @Test
    //  public void testNegGetBook() {
    //     List<String> bookList1 =  Arrays.asList("Book1");
    //     Library lib = new Library();
    //     lib.addBook("Book1");
    //      assertThrows(IllegalArgumentException.class, () -> {
    //          lib.getBooks();
    //      }, "Incorrect Balance Error!");
    //  }
    @Test
    public void testAddBook(){
        Library lib = new Library();
        lib.addBook("Book1");
        Boolean available = lib.isBookAvailable("Book1");
        assertTrue(available);
    }
    @Test
    public void testRemoveBook(){
        Library lib = new Library();
        lib.addBook("Book1");
        lib.removeBook("Book1");
        Boolean available = lib.isBookAvailable("Book1");
        assertFalse(available);
    }
    @Test
    public void testIsBookAvailable(){
        Library lib = new Library();
        lib.addBook("Book1");
        Boolean available = lib.isBookAvailable("Book1");
        assertTrue(available);
        Boolean  notavailable = lib.isBookAvailable("Book2");
        assertFalse(notavailable);
    }
}
