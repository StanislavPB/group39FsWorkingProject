package org.group39fsworkingproject.dto.managerDto;

import lombok.Data;

@Data
public class ManagerCreateRequestDto {

    private String managerName;
    private String password;
    private String email;

}
