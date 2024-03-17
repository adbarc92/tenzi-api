package com.barclay.tenziapi.e2e

import org.junit.jupiter.api.Nested
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest
@AutoConfigureMockMvc
class StudyGuideTests(@Autowired private val mockMvc: MockMvc) {

    @Nested
    inner class PostStudyGuide {
        // Study guides can be posted
        // Study guides are not posted without auth
        // Malformed study guides return an appropriate error
    }

    @Nested
    inner class GetStudyGuide {
        // Study guides can be retrieved
        // Others' study guides cannot be posted
        // Study guides are not posted without auth
        // Malformed study guides return an appropriate error
    }
}