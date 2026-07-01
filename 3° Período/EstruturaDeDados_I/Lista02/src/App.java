//------------------------- 1 -----------------------------
public int pesquisa(Node inicio, int dado) {
    Node atual = inicio;
    while (atual != null) {
        if (atual.dado == dado) {
            return 1;
        }
        atual = atual.proximo;
    }
    return 0;
}
//------------------------- 2 -----------------------------
public boolean isCrescente(Node inicio) {
    if (inicio == null || inicio.proximo == null) {
        return true;
    }
    Node atual = inicio;
    while (atual.proximo != null) {
        if (atual.dado > atual.proximo.dado) {
            return false;
        }
        atual = atual.proximo;
    }
    return true;
}
//------------------------- 3 -----------------------------
public Node removerPares(Node inicio) {
    while (inicio != null && inicio.dado % 2 == 0) {
        inicio = inicio.proximo;
    }
    if (inicio == null) {
        return null;
    }
    Node atual = inicio;
    while (atual.proximo != null) {
        if (atual.proximo.dado % 2 == 0) {
            atual.proximo = atual.proximo.proximo;
        } else {
            atual = atual.proximo;
        }
    }
    return inicio;
}
//------------------------- 4 -----------------------------
public int somaVetor(int[] vetor, int n) {
    if (n <= 0) {
        return 0;
    }
    return vetor[n - 1] + somaVetor(vetor, n - 1);
}
//------------------------- 5 -----------------------------
public String decimalParaBinario(int n) {
    if (n == 0) {
        return "0";
    }
    if (n == 1) {
        return "1";
    }
    return decimalParaBinario(n / 2) + String.valueOf(n % 2);
}