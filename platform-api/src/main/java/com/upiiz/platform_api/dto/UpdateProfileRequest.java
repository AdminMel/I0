package com.upiiz.platform_api.dto;

import jakarta.validation.constraints.Size;

import java.util.List;

public record UpdateProfileRequest(
        @Size(max=2000) String bio,
        List<String> interests,
        List<UserDTO.LinkDTO> links
) {}
