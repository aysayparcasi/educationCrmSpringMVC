package com.example.educationCrm.model.dto;


public interface StudentInformationDTO {
    //fieldları kısıtlandırıp sorgu işlemi yapmak istiyorsan böyle yap.
    //isimlendirme çok önemli--getName = name//
    //getSurname=surname ile eşleşmeliki sorguların doğru çalışsın.
    public Long getId();
    public String getName();
    public String getSurname();



}
