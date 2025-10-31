package com.rang.rangaudiovisualbackend.mapper;

import com.rang.rangaudiovisualbackend.dto.AdminDTO;
import com.rang.rangaudiovisualbackend.entity.Admin;

public interface AdminMapper {
    AdminDTO toDTO(Admin admin);
    AdminDTO toDTOSecure(Admin admin);
    Admin fromDTO(AdminDTO adminDTO);

}
