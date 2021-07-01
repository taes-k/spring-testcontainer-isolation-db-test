package com.taes.kim.dbisolationtest.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taes.kim.dbisolationtest.IntegrationTest;
import com.taes.kim.dbisolationtest.user.dto.UserDto;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("User 통합 테스트")
public class UserIT extends IntegrationTest
{
    @DisplayName("User1 등록")
    @BeforeEach
    void beforeEach_setUser1() throws Exception
    {
        // given
        String givenUserId = RandomStringUtils.random(10, true, false);
        UserDto.Req givenUser = new UserDto.Req();
        givenUser.setId(givenUserId);
        givenUser.setPassword("sample_password");
        givenUser.setName("sample_user_1");

        // when - then
        MockHttpServletRequestBuilder rq = MockMvcRequestBuilders.post("/users")
            .content(new ObjectMapper().writeValueAsString(givenUser))
            .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(rq)
            .andDo(log())
            .andExpect(status().isOk());
    }


    @DisplayName("전체 User 조회 -> 성공")
    @Test
    void getAllUsers_success() throws Exception
    {
        // given
        MockHttpServletRequestBuilder rq = MockMvcRequestBuilders
            .get("/users")
            .contentType(MediaType.APPLICATION_JSON);

        // when - then
        mockMvc.perform(rq)
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(greaterThan(1))));
    }
}
