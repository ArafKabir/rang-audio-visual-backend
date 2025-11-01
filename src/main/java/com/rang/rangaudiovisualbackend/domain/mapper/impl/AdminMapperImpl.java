package com.rang.rangaudiovisualbackend.domain.mapper.impl;

import com.rang.rangaudiovisualbackend.domain.dto.AdminDTO;
import com.rang.rangaudiovisualbackend.domain.entity.Admin;
import com.rang.rangaudiovisualbackend.domain.mapper.AdminMapper;
import org.springframework.stereotype.Component;

@Component
public class AdminMapperImpl implements AdminMapper {
    @Override
    public AdminDTO toDTO(Admin admin) {
        return new AdminDTO(
                admin.getId(),
                admin.getName(),
                admin.getEmail(),
                admin.getPassword(),
                admin.getPhoneNumber(),
                admin.getRole()
        );
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
        if (adminDTO == null) {
            return null;
        }

        Admin admin = new Admin();
        admin.setId(adminDTO.id());
        admin.setName(adminDTO.name());
        admin.setEmail(adminDTO.email());
        admin.setPassword(adminDTO.password());
        admin.setPhoneNumber(adminDTO.phoneNumber());
        admin.setRole(adminDTO.role());

        return admin;
    }
}
