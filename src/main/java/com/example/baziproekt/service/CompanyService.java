package com.example.baziproekt.service;



import com.example.baziproekt.model.Company;
<<<<<<< HEAD
=======
import com.example.baziproekt.model.Rating;
>>>>>>> 3978ccb44ab00caa15afabd6223ad96abc64c9a5

import java.util.List;

public interface CompanyService {

    List<Company> listAll();

    Company create(String name, String email);

    Company findById(Integer id);
<<<<<<< HEAD
=======

    Company updateRatings(Integer id, List<Rating> ratings);
>>>>>>> 3978ccb44ab00caa15afabd6223ad96abc64c9a5
}
