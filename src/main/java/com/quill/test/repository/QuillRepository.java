package com.quill.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.quill.test.model.Quill;

public interface QuillRepository extends JpaRepository<Quill, Long>{

}
