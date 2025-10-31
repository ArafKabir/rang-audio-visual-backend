package com.rang.rangaudiovisualbackend.domain.mapper;

import com.rang.rangaudiovisualbackend.domain.dto.AdminDTO;
import com.rang.rangaudiovisualbackend.domain.entity.Admin;

public interface AdminMapper {
    AdminDTO toDTO(Admin admin);
    AdminDTO toDTOSecure(Admin admin);
    Admin fromDTO(AdminDTO adminDTO);

}
