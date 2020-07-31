package challenge;

public class CriptografiaCesariana implements Criptografia {
    private static final String ALFABETO = "abcdefghijklmnopqrstuvwxyz";
    private static final int NUM_CASAS = 3;

    @Override
    public String criptografar(String texto) {
        texto = texto.toLowerCase();
        StringBuilder resposta = new StringBuilder();
        if (texto.isEmpty() || texto.isBlank()) {
            throw new IllegalArgumentException("Valor em branco ou nulo inválido.");
        }
        for (char letra : texto.toCharArray()) {
            int indice = ALFABETO.indexOf(letra);
            if (indice >= 0) {
                resposta.append(ALFABETO.charAt(((indice + ALFABETO.length() + NUM_CASAS) % ALFABETO.length())));
            } else {
                resposta.append(letra);
            }
        }
        return resposta.toString();
    }

    @Override
    public String descriptografar(String texto) {
        texto = texto.toLowerCase();
        StringBuilder resposta = new StringBuilder();
        if (texto.isEmpty() || texto.isBlank()) {
            throw new IllegalArgumentException("Valor em branco ou nulo inválido.");
        }
        for (char letra : texto.toCharArray()) {
            int indice = ALFABETO.indexOf(letra);
            if (indice >= 0) {
                resposta.append(ALFABETO.charAt(((indice + ALFABETO.length() - NUM_CASAS) % ALFABETO.length())));
            } else {
                resposta.append(letra);
            }
        }
        return resposta.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CriptografiaCesariana().descriptografar("abz1"));
    }
}
