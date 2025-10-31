package com.rang.rangaudiovisualbackend.domain.mapper.impl;

import com.rang.rangaudiovisualbackend.domain.dto.AdminDTO;
import com.rang.rangaudiovisualbackend.domain.entity.Admin;
import com.rang.rangaudiovisualbackend.domain.mapper.AdminMapper;
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
