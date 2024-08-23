package org.group39fsworkingproject.dto.managerDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.group39fsworkingproject.entity.Role;

@Data
@AllArgsConstructor
public class ManagerCreateResponseDto {

    private Integer id;
    private String managerName;
    private String role;

}
