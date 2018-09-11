package br.com.u2d.nfe.util;

import br.com.samuelweb.certificado.Certificado;
import br.com.samuelweb.certificado.CertificadoService;
import br.com.samuelweb.certificado.exception.CertificadoException;
import br.com.u2d.nfe.dom.ConfiguracoesIniciaisNfe;

import java.lang.invoke.MethodHandles;

public class Configuracao {

    private static ConfiguracoesIniciaisNfe configuraProxy(){
        String ip = "dpf.gov.br";
        String porta = "3128";
        String usuario = "david.djsc";
        String senha = "a#09wc";

        ConfiguracoesIniciaisNfe config = new ConfiguracoesIniciaisNfe();
        config.setProxy(ip, Integer.parseInt(porta), usuario, senha);
        return config;
    }

    public static ConfiguracoesIniciaisNfe iniciaConfiguracao(){
        try {
            Certificado certificado = certificadoA1Pfx();
            String schemas = "/opt/projetos/schemas";
            ConfiguracoesIniciaisNfe config = ConfiguracoesIniciaisNfe.iniciaConfiguracoes(Estados.DF, ConstantesUtil.AMBIENTE.HOMOLOGACAO, certificado, schemas);

            configuraProxy();
            return config;

        } catch (CertificadoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ConfiguracoesIniciaisNfe iniciaConfiguracaoWeb(){
        try {
            Certificado certificado = certificadoA1Pfx();
            ConfiguracoesIniciaisNfe config = ConfiguracoesIniciaisNfe.iniciaConfiguracoes(Estados.DF,
                    ConstantesUtil.AMBIENTE.HOMOLOGACAO,
                    certificado,
                    MethodHandles.lookup().lookupClass().getResource("/schemas").getPath(),
                    true);

            configuraProxy();
            return config;
        } catch (CertificadoException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Certificado certificadoA1Pfx() throws CertificadoException {
        String caminhoCertificado = "/opt/projetos/certificado/a1.pfx";
        String senha = "1234";
        return CertificadoService.certificadoPfx(caminhoCertificado, senha);
    }
}
