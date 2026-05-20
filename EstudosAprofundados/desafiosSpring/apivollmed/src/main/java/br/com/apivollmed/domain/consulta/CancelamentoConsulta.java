package br.com.apivollmed.domain.consulta;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cancelamentos_consultas")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CancelamentoConsulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "consulta_id")
    private Consulta consultaId;

    @Column(name = "motivo")
    @Enumerated(EnumType.STRING)
    private MotivoCancelamento motivo;

    public CancelamentoConsulta(Long id, Consulta consultaId, MotivoCancelamento motivo) {
        this.id = id;
        this.consultaId = consultaId;
        this.motivo = motivo;
    }

    public Long getId() {
        return id;
    }

    public Consulta getConsultaId() {
        return consultaId;
    }

    public MotivoCancelamento getMotivo() {
        return motivo;
    }
}
