package br.com.u2d.nfe.util;

import br.com.samuelweb.certificado.Certificado;
import br.com.samuelweb.certificado.CertificadoService;
import br.com.samuelweb.certificado.exception.CertificadoException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CertificadoA1Pfx {

    public static void main(String[] args) {
        try {
            Certificado certificado = certificadoA1Pfx();
            System.out.println("Alias Certificado :" +certificado.getNome());
            System.out.println("Dias Restantes Certificado :" +certificado.getDiasRestantes());
            System.out.println("Validade Certificado :" +certificado.getVencimento());

            //PARA REGISTRAR O CERTIFICADO NA SESSAO, FAÇA SOMENTE EM PROJETOS EXTERNO
            //JAVA NFE, CTE E OUTRAS APIS MINHAS JA CONTEM ESTA INICIALIZAÇÃO
            CertificadoService.inicializaCertificado(certificado, new FileInputStream(new File("caminhoCacert")));

        } catch (CertificadoException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Certificado certificadoA1Pfx() throws CertificadoException {
        String caminhoCertificado = "/opt/projetos/certificado/a1.pfx";
        String senha = "1234";
        return CertificadoService.certificadoPfx(caminhoCertificado, senha );
    }
}
