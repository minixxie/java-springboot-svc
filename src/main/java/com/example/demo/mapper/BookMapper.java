package com.example.demo.mapper;

import com.example.demo.model.Book;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * MyBatis mapper for table "book".
 */
@Mapper
@Repository
public interface BookMapper {
  @Select("SELECT * FROM book")
  public List<Book> findAll();

  @Select("SELECT * FROM book WHERE id = #{id}")
  public Optional<Book> findById(Long id);

  @Insert("INSERT INTO book (isbn, title) VALUES (#{isbn}, #{title})")
  @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
  public int insert(Book book);
}
