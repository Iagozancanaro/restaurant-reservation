[33mcommit 516495ca7e6c1f15ce417adb6972887b8e56fc13[m[33m ([m[1;36mHEAD[m[33m -> [m[1;32mmain[m[33m, [m[1;31morigin/main[m[33m)[m
Author: Iago Zancanaro <iagozancanaro@gmail.com>
Date:   Mon Oct 6 21:11:35 2025 -0300

    feat: add REST controllers for Mesa, Reserva, Cliente and Restaurante entities

[33mcommit 5318037c60b1ba39f06e2f9b501284afc5824801[m
Author: Iago Zancanaro <iagozancanaro@gmail.com>
Date:   Wed Oct 1 21:35:50 2025 -0300

    feat: implement business rules for reservations and table status

[33mcommit 609033ff5e1d0f1aa89ed26d4b5720377c7c1e00[m
Author: Iago Zancanaro <iagozancanaro@gmail.com>
Date:   Sat Sep 27 18:45:22 2025 -0300

    feat: create exceptions and GlobalExceptionHandler

[33mcommit 326d6e79dae8d0039a4c4d5e78da04fad93f002b[m
Author: Iago Zancanaro <iagozancanaro@gmail.com>
Date:   Thu Sep 25 21:47:37 2025 -0300

    feat: implements business logic for Reserva use cases and register related beans

[33mcommit e9ee9b41df9358e0c3769e6689514c81105374ce[m
Author: Iago Zancanaro <iagozancanaro@gmail.com>
Date:   Thu Sep 25 21:39:20 2025 -0300

    feat: implemente business logic for Restaurante use cases and register related beans

[33mcommit 9a57faa1ac997b4b39854f344426e9491c058226[m
Author: Iago Zancanaro <iagozancanaro@gmail.com>
Date:   Thu Sep 25 21:32:05 2025 -0300

    feat: implement business logic for Mesa use cases and register related beans

[33mcommit 3dedd776dcf5d67ae2402d01bb7b6ba346212e77[m
Author: Iago Zancanaro <iagozancanaro@gmail.com>
Date:   Thu Sep 25 20:52:19 2025 -0300

    feat: implement business logic for Cliente use cases and register related beans

[33mcommit 8964667571d5c9df2f86a117aa4b761f79fada1d[m
Author: Iago Zancanaro <iagozancanaro@gmail.com>
Date:   Thu Sep 25 20:46:32 2025 -0300

    fix: fix typos in V1__criar_tabelas.sql

[33mcommit 87b6528efc163949ec47f936e8ca5acd26548211[m
Author: Iago Zancanaro <iagozancanaro@gmail.com>
Date:   Thu Sep 25 20:38:44 2025 -0300

    fix: fix OneToMany/ManyToOne relationship to prevent table creation

[33mcommit 33c33e19ea0a848c704941bbc4ffcddecc1c38fd[m
Author: Iago Zancanaro <iagozancanaro@gmail.com>
Date:   Tue Sep 23 21:52:50 2025 -0300

    feat: add gateways and repositories for all entities
    
    - Created core gateways for Cliente, Mesa, Reserva e Restaurante
    - Implemented infrastructure repositories using JPA
    - Added repository gateways implementing core gateways
    - Mapped entities to domain objects via mappers

[33mcommit 17fc2573abae1b3a02b774b3927e5807b94eb7a9[m
Author: Iago Zancanaro <iagozancanaro@gmail.com>
Date:   Tue Sep 23 20:27:56 2025 -0300

    feat: add initial structure for all use cases

[33mcommit 85440f63108b8be51b8666dd4427e08eab74ddc6[m
Author: Iago Zancanaro <iagozancanaro@gmail.com>
Date:   Mon Sep 22 14:41:48 2025 -0300

    feat: add DTOs and mappers for all entities

[33mcommit 99dc19d653f144ec7e950ea7d6db299e7de79a17[m
Author: Iago Zancanaro <iagozancanaro@gmail.com>
Date:   Mon Sep 22 13:04:33 2025 -0300

    feat: add initial database migration (V1) with all tables, Pks, Fks and enums

[33mcommit d4738f3e540325f654f31b1bfe4d8448b8484597[m
Author: Iago Zancanaro <iagozancanaro@gmail.com>
Date:   Mon Sep 22 12:09:49 2025 -0300

    feat: implement domain records and persistence entities with OneToMany and ManyToOne mappings

[33mcommit 2debfcdb5247abb9d94fa151810f9ec65f0dfa49[m
Author: Iago Zancanaro <iagozancanaro@gmail.com>
Date:   Mon Sep 22 10:35:16 2025 -0300

    chore: initial project setup with docker-compose and .env example
