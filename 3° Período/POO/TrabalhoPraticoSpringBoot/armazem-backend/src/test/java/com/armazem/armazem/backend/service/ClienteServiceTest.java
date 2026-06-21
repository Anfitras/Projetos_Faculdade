package com.armazem.armazem.backend.service;

import com.armazem.armazem.backend.model.Cliente;
import com.armazem.armazem.backend.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    private Cliente clienteNovo;
    private Cliente clienteSalvo;

    @BeforeEach
    public void setup() {
        clienteNovo = new Cliente();
        clienteNovo.setNome("Joao Silva");
        clienteNovo.setCpf("12345678901");

        clienteSalvo = new Cliente();
        clienteSalvo.setId(1L);
        clienteSalvo.setNome("Joao Silva");
        clienteSalvo.setCpf("12345678901");
    }

    @Test
    public void testSalvarClienteNovo() {
        Mockito.when(clienteRepository.findByCpf("12345678901")).thenReturn(Optional.empty());
        Mockito.when(clienteRepository.save(any(Cliente.class))).thenReturn(clienteSalvo);

        Cliente salvo = clienteService.salvar(clienteNovo);

        assertNotNull(salvo);
        assertEquals(1L, salvo.getId());
        assertEquals("12345678901", salvo.getCpf());
    }

    @Test
    public void testSalvarClienteCpfDuplicado() {
        Mockito.when(clienteRepository.findByCpf("12345678901")).thenReturn(Optional.of(clienteSalvo));

        assertThrows(RuntimeException.class, () -> {
            clienteService.salvar(clienteNovo);
        });
    }
}
