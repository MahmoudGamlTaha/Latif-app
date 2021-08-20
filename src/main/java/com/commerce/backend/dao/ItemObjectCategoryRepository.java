package com.commerce.backend.dao;

import com.commerce.backend.model.entity.ItemObjectCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.annotations.Where;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface ItemObjectCategoryRepository extends JpaRepository<ItemObjectCategory, Long> {
   
	Page<ItemObjectCategory> findAll(Pageable pageable);
	
   @Query("SELECT u FROM ItemObjectCategory u WHERE u.type = ?1 AND u.active in (true, ?2) ")
    Page<ItemObjectCategory> findByType(Integer type, boolean notActive, Pageable page);
    
   @Query(value = "SELECT * FROM item_category WHERE parent_id = ?1 ", nativeQuery = true)
   List<ItemObjectCategory> findByCategory(Long category);
   
  // @Where(clause ="active = true AND parent is NULL")
   @Query("SELECT u FROM ItemObjectCategory u WHERE u.type = ?1 and u.parent is null")
   Page<ItemObjectCategory>findByType(Integer type, Pageable page);
  @Transactional
   @Modifying
   @Query("UPDATE ItemObjectCategory item SET item.active = ?1 WHERE item.id = ?2  ") 
   Integer activateCategory(Boolean active, Long id);
   
   Page<ItemObjectCategory> findByShowInterest(boolean show, Pageable page);
   
}
