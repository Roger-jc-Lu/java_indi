package cryptograpy;

import javax.crypto.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.KeyStore.Entry;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.cert.CertificateException;

public final class Cryptograpy {

    public static SecretKey secretKeyGenerator() throws NoSuchAlgorithmException{
    
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = new SecureRandom();
        int keyBitSize = 256;
        keyGenerator.init(keyBitSize, secureRandom);
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey;
    }

    public static KeyPair keyPairGenerator() throws NoSuchAlgorithmException{
    
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return keyPair;
    }
    
    public static KeyStore createEmptyKeyStore() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException{

        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        char[] keyStorePassword = "RogerLu".toCharArray();
        keyStore.load(null, keyStorePassword);
        return keyStore;
    }

    public static KeyStore loadKeyStore(File file) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException{

        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        char[] keyStorePassword = "RogerLu".toCharArray();
        try(InputStream keyStoreData = new FileInputStream(file)){
            keyStore.load(keyStoreData, keyStorePassword);
        }
        return keyStore;
    }

    public static void saveKeyStore(KeyStore keyStore, File file) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException{

        char[] keyStorePassword = "RogerLu".toCharArray();
        try (FileOutputStream keyStoreOutputStream = new FileOutputStream(file)) {
            keyStore.store(keyStoreOutputStream, keyStorePassword);
        }
    }

    public static void setSecretKey(KeyStore keyStore, SecretKey secretKey) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException{

        char[] keyPassword = "RogerLu".toCharArray();
        KeyStore.ProtectionParameter entryPassword = new KeyStore.PasswordProtection(keyPassword);
        KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(secretKey);
        keyStore.setEntry("keyAlias1", secretKeyEntry, entryPassword);
    }

    public static void setPrivateKey(KeyStore keyStore, KeyPair keyPair) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException{

        char[] keyPassword = "RogerLu".toCharArray();
        KeyStore.ProtectionParameter entryPassword = new KeyStore.PasswordProtection(keyPassword);
        KeyStore.PrivateKeyEntry keyPairEntry = new KeyStore.PrivateKeyEntry(keyPair.getPrivate(), null);
        keyStore.setEntry("keyAlias2", keyPairEntry, entryPassword);
    }

    public static Entry getSecretKey(KeyStore keyStore) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException , UnrecoverableEntryException{

        char[] keyPassword = "RogerLu".toCharArray();
        KeyStore.ProtectionParameter entryPassword = new KeyStore.PasswordProtection(keyPassword);
        KeyStore.Entry keyEntry = keyStore.getEntry("keyAlias1", entryPassword);
        return keyEntry;
    }
   
    public static PrivateKeyEntry getPrivateKey(KeyStore keyStore) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException , UnrecoverableEntryException{

        char[] keyPassword = "RogerLu".toCharArray();
        KeyStore.ProtectionParameter entryPassword = new KeyStore.PasswordProtection(keyPassword);
        KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry("keyAlias2", entryPassword);
        return privateKeyEntry;
    }
    
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, KeyStoreException,
            CertificateException, IOException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        File file = new File("week8\\src\\main\\java\\cryptograpy\\keyStore.ks");
        File outputFile = new File("week8\\src\\main\\java\\cryptograpy\\message.txt");
        FileOutputStream fos=new FileOutputStream(outputFile);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        SecretKey secretKey = secretKeyGenerator();
        KeyPair keyPair = keyPairGenerator();
        KeyStore keyStore = createEmptyKeyStore();
        setSecretKey(keyStore, secretKey);
        setPrivateKey(keyStore, keyPair);
        saveKeyStore(keyStore,file);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] originalText  = "Roger Lu's Java Independent Study".getBytes("UTF-8");
        byte[] encryptedText = cipher.doFinal(originalText);
        fos.write(encryptedText);
        fos.close();
        
    }
}
