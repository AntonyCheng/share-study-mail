package top.sharehome.share_study_mail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.sharehome.share_study_mail.utils.EmailUtil;

import javax.annotation.Resource;

@SpringBootTest
class ShareStudyMailApplicationTests {

    /**
     * 注入发送邮件的接口
     */
    @Resource
    private EmailUtil emailUtil;

    /**
     * 测试发送文本邮件
     */
    @Test
    public void sendmail() {
        emailUtil.sendSimpleMail("2272760097@qq.com", "主题：你好!", "内容：第一封邮件");
    }

    @Test
    public void sendmailHtml() {
        emailUtil.sendHtmlMail("1911261716@qq.com", "主题：你好html邮件", "<h1>内容：第一封html邮件</h1>");
    }

}
