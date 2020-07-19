package org.spring.springboot.service.ServiceImp;

import org.spring.springboot.dao.attentions.*;
import org.spring.springboot.dao.devices.DevIdDao;
import org.spring.springboot.dao.emails.EmailUserAccountDao;
import org.spring.springboot.domain.AttentionItem;
import org.spring.springboot.domain.Device;
import org.spring.springboot.domain.Email;
import org.spring.springboot.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttentionServiceImp implements AttentionService {
    @Autowired
    AttentionAddDao attentionAddDao;

    @Autowired
    AttentionUserAccountAndDevIdDao attentionUserAccountAndDevIdDao;

    @Autowired
    AttentionsCancelByDevId attentionsCancelByDevId;

    @Autowired
    AttentionsByUserAccountDao attentionsByUserAccountDao;

    @Autowired
    EmailUserAccountDao emailUserAccountDao;

    @Autowired
    DevIdDao devIdDao;

    @Autowired
    AttentionDeviceDao attentionDeviceDao;

    @Autowired
    EmailClient emailClient;


    private void sendMail(String userAccount, int devId, int t, String text) throws Exception {
        List<Email> emails = emailUserAccountDao.findEmailByUserAccount(userAccount);
        if (emails.size() == 0) {
            throw new Exception("email not exist");
        }
        String emailAddress = emails.get(0).getEmailAddress();
        List<Device> devices = devIdDao.findDeviceBydevId(devId);
        if (devices.size() == 0) {
            throw new Exception("device not exist");
        }
        String devName = devices.get(0).getDevName();
        emailClient.sendMail(emailAddress, (t == 1 ? "您关注了" : "您取消关注了") + "名为" + devName + "的设备", text);
    }

    @Override
    public List<AttentionItem> addAttentionRecord(String userAccount, Integer devId) throws Exception {
        List<AttentionItem> attentionItems = attentionUserAccountAndDevIdDao.findAttentionByUserAccountAndDevId(userAccount, devId);
        if (attentionItems.size() == 1) {
            throw new Exception("already attention this device");
        }
        attentionAddDao.addAttention(userAccount, devId);
//        sendMail(userAccount, devId, 1, "我们会及时告知您此设备的状态，感谢您的使用。若非本人操作请及时修改密码");
        return null;
    }

    @Override
    public List<AttentionItem> cancelAttentionRecord(String userAccount, Integer devId) throws Exception {
        List<AttentionItem> attentionItems = attentionUserAccountAndDevIdDao.findAttentionByUserAccountAndDevId(userAccount, devId);
        if (attentionItems.size() == 0) {
            throw new Exception("attention not exist");
        }
        attentionsCancelByDevId.deleteAttentionsByDevId(userAccount, devId);
//        sendMail(userAccount, devId, 0, "感谢您的使用。若非本人操作请及时修改密码");
        return null;
    }

    @Override
    public List<AttentionItem> FindAttentionRecord(String userAccount) throws Exception {
        return attentionsByUserAccountDao.findAttentionByUserAccount(userAccount);
    }

    @Override
    public List<Device> FindAttentionDevices(String userAccount) throws Exception {
        return attentionDeviceDao.findDevice(userAccount);
    }
}
