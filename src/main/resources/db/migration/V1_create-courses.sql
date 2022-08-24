    private Long cursoId;

    @NotBlank
    @Column(name = "curso_name")
    private String name;

    @NotBlank
    @Column(name = "curso_name_normalized")
    private String normalizedName;

    CREATE TABLE curso (
        curso_id int8 PRIMARY KEY,
        curso_name VARCHAR(25),
        curso_name_normalized VARCHAR(25)
    )