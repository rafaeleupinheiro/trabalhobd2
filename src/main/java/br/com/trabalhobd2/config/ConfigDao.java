package br.com.trabalhobd2.config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigDao {
    private static Properties properties = new Properties();
    private static String arquivo = "config.ini";
    private static Config config;

    public static Config getConfig() {
        try {
            properties.load(new FileInputStream(arquivo));

            String servidor = properties.getProperty("servidor");
            String instancia = properties.getProperty("instancia");
            String porta = properties.getProperty("porta");
            String banco = properties.getProperty("banco");
            String usuario = properties.getProperty("usuario");
            String senha = properties.getProperty("senha");

            config = new Config(servidor, instancia, porta, banco, usuario,
                    senha);
        } catch (IOException ex) {
            Logger.getLogger(ConfigDao.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        return config;
    }

    public static void setConfig(String servidor, String instancia,
                                 String porta, String banco, String usuario, String senha) {

        try {
            properties.load(new FileInputStream(arquivo));
            FileOutputStream fos = new FileOutputStream(arquivo);

            properties.setProperty("servidor", servidor);
            properties.setProperty("instancia", instancia);
            properties.setProperty("porta", porta);
            properties.setProperty("banco", banco);
            properties.setProperty("usuario", usuario);
            properties.setProperty("senha", senha);
            properties.store(fos, "");
            fos.close();

        } catch (IOException ex) {
            Logger.getLogger(ConfigDao.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

}
