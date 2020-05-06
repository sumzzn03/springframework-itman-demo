package ioccontainer;


import ioccontainer.entity.Book;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className BookService
 * @description
 * @JunitTest: {@link  }
 * @date 2020-05-06 21:38
 **/
public class BookService implements IBookService {

    /*** 模拟数据库 */
    private static Map<Long, Book> books = new HashMap<>();

    static {
        Book book1 = new Book();
        book1.setId(2L);
        book1.setName("SpringFramework");
        book1.setPrice(50);
        books.put(1L, book1);
        Book book2 = new Book();
        book2.setId(2L);
        book2.setName("SpringFramework");
        book2.setPrice(30);
        books.put(2L, book2);
    }

    @Override
    public Book findById(Long id) {

        return books.get(id);
    }

    @Override
    public void save(Book book) {
        books.put(book.getId(), book);
        System.out.println("保存成功:" + book);
    }

    @Override
    public void update(final Book book) {
        Optional<Long> first = books.entrySet().stream().map(_book -> _book.getKey()).filter(id -> id.longValue() == book.getId()).findFirst();
        first.ifPresent((id) -> {
            books.put(id, book);
        });
    }
}
