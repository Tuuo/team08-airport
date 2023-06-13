package com.isoft.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name = "COMMON_META")
@Data
public class Meta implements Serializable {
    private String sndr;
    private String rcvr;
    @Id
    private Long seqn;
    private String ddtm;
    private String type;
    private String styp;
}

