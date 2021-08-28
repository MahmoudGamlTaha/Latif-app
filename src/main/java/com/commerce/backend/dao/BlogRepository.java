package com.commerce.backend.dao;

import com.commerce.backend.model.entity.Blog;

import com.commerce.backend.model.entity.BlogCategory;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    @Query(value = "SELECT b FROM Blog b LEFT JOIN FETCH b.userId WHERE CONCAT(b.title, b.description) LIKE %?1% and b.active = true order by created_at desc ",
            countQuery = "SELECT count(*) FROM Blog b WHERE b.active = true and CONCAT(b.title, b.description) LIKE %?1%",
            nativeQuery = false)
    Page<Blog> findAll(String keyword, Pageable pageable);

   // @Query(value = "SELECT * FROM Blogs b WHERE   b.active = true order by created_at desc ",
     //       countQuery = "SELECT count(*) FROM Blogs b WHERE b.active = true",
       //     nativeQuery = true)
    @Query(value= "SELECT b FROM Blog b LEFT JOIN FETCH  b.userId  WHERE b.active = true  order by b.created_at desc",
    		countQuery = "SELECT count(*) FROM Blog b WHERE b.active = true")
    Page<Blog> findAll(Pageable pageable);
    
    @Query(value= "SELECT b FROM Blog b LEFT JOIN FETCH  b.userId  WHERE b.active = true AND b.category = ?1  order by b.created_at desc ",
    		countQuery = "SELECT count(*) FROM Blog b WHERE b.active = true AND b.category = ?1")
    Page<Blog> findByCategory(BlogCategory category, Pageable pageable);
   
    @Query(value= "SELECT b FROM Blog b LEFT JOIN FETCH  b.userId  WHERE b.id = ?1 ")
    Optional<Blog> findById(Long id);
    
    @Query(value = "SELECT count(*) FROM Blog b WHERE b.userId.id = ?1")
    Integer countByUser(Long userId);
}
