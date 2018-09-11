package br.com.u2d.nfe.resource;

import br.com.u2d.nfe.exception.NfeException;
import br.com.u2d.nfe.servicos.Nfe;
import br.com.u2d.nfe.util.Configuracao;
import br.com.u2d.nfe.util.ConstantesUtil;
import br.inf.portalfiscal.nfe.schema_4.retConsStatServ.TRetConsStatServ;

public class StatusSefazTest {

    public static void main(String[] args) throws NfeException {

        Configuracao.iniciaConfiguracaoWeb();

        TRetConsStatServ retorno = Nfe.statusServico(ConstantesUtil.NFE);
        System.out.println("Status:" + retorno.getCStat());
        System.out.println("Motivo:" + retorno.getXMotivo());
        System.out.println("Data:" + retorno.getDhRecbto());
    }
}
