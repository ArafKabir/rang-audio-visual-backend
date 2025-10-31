package com.rang.rangaudiovisualbackend.mapper.impl;

import com.rang.rangaudiovisualbackend.dto.AdminDTO;
import com.rang.rangaudiovisualbackend.entity.Admin;
import com.rang.rangaudiovisualbackend.mapper.AdminMapper;
import org.springframework.stereotype.Component;

@Component
public class AdminMapperImpl implements AdminMapper {
    @Override
    public AdminDTO toDTO(Admin admin) {
        return null;
    }

    @Override
    public AdminDTO toDTOSecure(Admin admin) {
        return new AdminDTO(
                admin.getId(),
                admin.getName(),
                admin.getEmail(),
                null,
                admin.getPhoneNumber(),
                admin.getRole()
        );
    }

    @Override
    public Admin fromDTO(AdminDTO adminDTO) {
        return null;
    }
}
