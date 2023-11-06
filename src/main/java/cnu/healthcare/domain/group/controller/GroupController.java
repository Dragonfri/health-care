package cnu.healthcare.domain.group.controller;

import cnu.healthcare.domain.group.controller.dto.request.GroupDto;
import cnu.healthcare.domain.group.controller.dto.response.GroupCodeRespDto;
import cnu.healthcare.domain.group.service.GroupService;
import cnu.healthcare.domain.member.controller.dto.request.RegisterDto;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cnu.healthcare.domain.group.controller.GroupController.REST_URL_GROUP;

@RequiredArgsConstructor
@RestController
@RequestMapping(REST_URL_GROUP)
public class GroupController {

    private final GroupService groupService;
    public static final String REST_URL_GROUP = "api/mvp/group";

    @PostMapping("/register")
    @ApiOperation(value = "회원가입")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberId", value = "member 고유한 id"),
            @ApiImplicitParam(name = "groupName", value = "Group name")
    })
    @ApiResponses({
            @ApiResponse(code = 201, message = "created"),
            @ApiResponse(code = 400, message = "wrong request"),
            @ApiResponse(code = 500, message = "server error")
    })
    public ResponseEntity<GroupCodeRespDto> register(@RequestBody GroupDto groupDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(groupService.createGroup(groupDto));
    }
}
