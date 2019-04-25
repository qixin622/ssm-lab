package com.ssm.lab.service;

import com.ssm.lab.bean.Borrow;

import java.util.List;

public interface BorrowService {

    Borrow getByid(Integer id);

    List<Borrow> getAll();

    int remove(String id);

    int add(Borrow borrow);

    int edit(Borrow borrow);

    int editBack(Borrow borrow);

    List<Borrow> getByType(String type, String keywords);



}
