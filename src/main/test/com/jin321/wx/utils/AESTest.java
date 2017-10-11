package com.jin321.wx.utils;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

/**
 * @Author hao
 * @Date 2017/10/9 23:07
 * @Description :
 */
public class AESTest {
    @Test
    public void decrypt() throws Exception {
//        String encryptedData =
//                "5/ObpwkmRX+dAmiHJFRZ52PYwnxzWHCHW96CPuEswYMj+UINoEhVDufCutsromZq3qY8YDZ14v2tcG3Lm5kEtYVgwf0H2hV+obin58x10Ukn4gV2kBRTO2LN6XRhp96ApbVzbhDZX+3XIzfT7jmCGRobl8VL0lbH2/5XPoXBzhOuDokZd8vGdit6dRWwtxAR2SukCCInmM/DR/hBIKGIaCRoEnswJG1QJe3PT757QjIuQonBJIGrI7NE3Pap+qfWxHsbgB7Smqn7XPKkl/hE06RVZtSPcx8jwVL3cxBMBqwTYaAIu2PC91wKRnYhiyP1zQ1Y5xn+pl+fh9LZye11Mz72ABwE5HQBmzfiWEWNpckuCZCjiSc+P6/RnqJkmzYv2e/EGvq34y4ZcHICZ+f8TBHSe3in5/gEveWNuzPx6A9/r3RiB97TN4TvkczPS7yf";
//        String sessionKey = "tY2vqkZeFNdeS/KFBWaoGg==";
//        String iv = "0atCNV08BHZQwd4WwqKDqw==";

        String appId = "wx4f4bc4dec97d474b";
        String sessionKey = "tiihtNczf5v6AKRyjwEUhQ==";
        String encryptedData = "CiyLU1Aw2KjvrjMdj8YKliAjtP4gsMZMQmRzooG2xrDcvSnxIMXFufNstNGTyaGS9uT5geRa0W4oTOb1WT7fJlAC+oNPdbB+3hVbJSRgv+4lGOETKUQz6OYStslQ142dNCuabNPGBzlooOmB231qMM85d2/fV6ChevvXvQP8Hkue1poOFtnEtpyxVLW1zAo6/1Xx1COxFvrc2d7UL/lmHInNlxuacJXwu0fjpXfz/YqYzBIBzD6WUfTIF9GRHpOn/Hz7saL8xz+W//FRAUid1OksQaQx4CMs8LOddcQhULW4ucetDf96JcR3g0gfRK4PC7E/r7Z6xNrXd2UIeorGj5Ef7b1pJAYB6Y5anaHqZ9J6nKEBvB4DnNLIVWSgARns/8wR2SiRS7MNACwTyrGvt9ts8p12PKFdlqYTopNHR1Vf7XjfhQlVsAJdNiKdYmYVoKlaRv85IfVunYzO0IKXsyl7JCUjCpoG20f0a04COwfneQAGGwd5oa+T8yO5hzuyDb/XcxxmK01EpqOyuxINew==";
        String iv = "r7BXXKkLb8qrSNn05n0qiA==";
        AES aes = new AES();
        byte[] resultByte = aes.decrypt(Base64.decodeBase64(encryptedData), Base64.decodeBase64(sessionKey), Base64.decodeBase64(iv));
        String userInfo = new String(resultByte, "UTF-8");
        System.out.println(userInfo);
        System.out.println(sessionKey.length());
        System.out.println(encryptedData.length());
        System.out.println(iv.length());
    }

}