import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Cracha {

        private Map<String, LocalDateTime> codigoAcessoMap;

        public Cracha() {
            codigoAcessoMap = new HashMap<>();
        }

        public void registrarEntrada(String codigo) {
            if (codigoAcessoMap.containsKey(codigo)) {
                System.out.println("Obrigado pela visita! ");
            } else {
                codigoAcessoMap.put(codigo, LocalDateTime.now());
                System.out.println("Bem-vindo, acesso liberado! ");
            }
        }

        public void registrarSaida(String codigo) {
            if (codigoAcessoMap.containsKey(codigo)) {
                LocalDateTime entrada = codigoAcessoMap.get(codigo);
                LocalDateTime saida = LocalDateTime.now();
                codigoAcessoMap.remove(codigo);
                System.out.println("Obrigado pela visita. Entrada: " + entrada.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) +
                        ", Saída: " + saida.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            } else {
                System.out.println("Código de acesso inválido");
            }
        }
    }

