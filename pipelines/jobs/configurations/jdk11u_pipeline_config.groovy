class Config11 {

    final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac    : [
            os                  : 'mac',
            arch                : 'x64',
            additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.mac.10_15',
            test                : 'default',
            configureArgs       : [
                    'openj9'      : '--enable-dtrace=auto  --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                    'temurin'     : '--enable-dtrace=auto'
            ],
            buildArgs           : [
                    'temurin'   : '--create-sbom',
                    'openj9'    : '--ssh'
            ]
        ],

        x64Linux  : [
            os                  : 'linux',
            arch                : 'x64',
            additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
            dockerImage         : 'adoptopenjdk/centos6_build_image',
            dockerFile: [
                    openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
            ],
            dockerNode          : 'sw.tool.docker && sw.config.uid1000',
            dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
            test                : 'default',
            configureArgs       : [
                    'openj9'      : '--disable-ccache --enable-dtrace=auto --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                    'temurin'     : '--enable-dtrace=auto',
                    'corretto'    : '--enable-dtrace=auto',
                    'SapMachine'  : '--enable-dtrace=auto',
                    'dragonwell'  : '--enable-dtrace=auto --enable-unlimited-crypto --with-jvm-variants=server --with-zlib=system --with-jvm-features=zgc',
                    'fast_startup': '--enable-dtrace=auto',
                    'bisheng'     : '--enable-dtrace=auto --with-extra-cflags=-fstack-protector-strong --with-extra-cxxflags=-fstack-protector-strong --with-jvm-variants=server --disable-warnings-as-errors'
            ],
            buildArgs            : [
                'temurin'     : '--create-source-archive --create-sbom',
                'openj9'      : '--ssh'
            ]
        ],

        x64AlpineLinux  : [
                os                  : 'alpine-linux',
                arch                : 'x64',
                dockerImage         : 'adoptopenjdk/alpine3_build_image',
                test                : 'default',
                configureArgs       : '--enable-headless-only=yes',
                buildArgs           : [
                        'temurin'   : '--create-sbom'
                ]
        ],

        aarch64AlpineLinux  : [
                os                  : 'alpine-linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/alpine3_build_image',
                test                : 'default',
                configureArgs       : '--enable-headless-only=yes',
                buildArgs           : [
                        'temurin'   : '--create-sbom'
                ]
        ],

        x64Windows: [
            os                  : 'windows',
            arch                : 'x64',
            additionalNodeLabels: [
                    openj9:     'ci.project.openj9 && hw.arch.x86 && sw.os.windows',
                    temurin:    'win2022&&vs2019',
                    dragonwell: 'win2012'
            ],
            test                : 'default',
            buildArgs : [
                temurin : '--jvm-variant client,server --create-sbom',
                'openj9'    : '--ssh'
            ],
            configureArgs       : [
                    'openj9'      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-jdk-rc-name="IBM Semeru Runtime"',
                    'temurin' : '--jvm-variant client,server'
            ]
        ],

        x32Windows: [
            os                  : 'windows',
            arch                : 'x86-32',
            additionalNodeLabels: 'win2022&&vs2019',
            buildArgs : [
                    temurin : '--jvm-variant client,server --create-sbom'
            ],
            test                : 'default'
        ],

        ppc64Aix    : [
            os                  : 'aix',
            arch                : 'ppc64',
            additionalNodeLabels: [
                    openj9:  'hw.arch.ppc64 && sw.os.aix.7_2',
                    temurin: 'xlc13&&aix720',
            ],
            test                : 'default',
            additionalTestLabels: [
                    temurin: 'sw.os.aix.7_2'
            ],
            cleanWorkspaceAfterBuild: true,
            configureArgs       : [
                    'openj9'      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
            ],
            buildArgs           : [
                    'temurin'   : '--create-sbom',
                    'openj9'    : '--ssh'
            ]
        ],

        s390xLinux    : [
            os                  : 'linux',
            arch                : 's390x',
            test                : 'default',
            additionalNodeLabels: [
                    openj9:  'hw.arch.s390x && (sw.os.cent.7 || sw.os.rhel.7)'
            ],
            dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
            configureArgs       : '--enable-dtrace=auto --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
            buildArgs           : [
                    'temurin'   : '--create-sbom',
                    'openj9'    : '--ssh'
            ]
        ],

        sparcv9Solaris    : [
            os                  : 'solaris',
            arch                : 'sparcv9',
            test                : false,
            configureArgs       : '--enable-dtrace=auto',
            buildArgs           : [
                    'temurin'   : '--create-sbom'
            ]
        ],

        ppc64leLinux    : [
            os                  : 'linux',
            arch                : 'ppc64le',
            test                : 'default',
            additionalNodeLabels: [
                    openj9:  'hw.arch.ppc64le && (sw.os.cent.7 || sw.os.rhel.7)'
            ],
            dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
            configureArgs       : [
                    'temurin'     : '--enable-dtrace=auto',
                    'openj9'      : '--enable-dtrace=auto --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
            ],
            buildArgs           : [
                    'temurin'   : '--create-sbom',
                    'openj9'    : '--ssh'
            ]
        ],

        arm32Linux    : [
            os                  : 'linux',
            arch                : 'arm',
            test                : 'default',
            configureArgs       : '--enable-dtrace=auto',
            buildArgs           : [
                    'temurin'   : '--create-sbom'
            ]
        ],

        aarch64Linux    : [
            os                  : 'linux',
            arch                : 'aarch64',
            dockerImage         : 'adoptopenjdk/centos7_build_image',
            dockerNode         : 'sw.tool.docker',
            dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
            additionalNodeLabels: [
                    openj9:  'hw.arch.aarch64 && sw.os.linux'
            ],
            test                : 'default',
            configureArgs       : [
                    'temurin' : '--enable-dtrace=auto',
                    'openj9' : '--enable-dtrace=auto  --without-version-opt  --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                    'corretto' : '--enable-dtrace=auto',
                    'dragonwell' : '--enable-dtrace=auto --with-extra-cflags=\"-march=armv8.2-a+crypto\" --with-extra-cxxflags=\"-march=armv8.2-a+crypto\"',
                    'bisheng' : '--enable-dtrace=auto --with-extra-cflags=-fstack-protector-strong --with-extra-cxxflags=-fstack-protector-strong --with-jvm-variants=server'
            ],
            buildArgs           : [
                    'openj9'    : '--ssh'
            ]
        ],

        riscv64Linux      :  [
            os                   : 'linux',
            arch                 : 'riscv64',
            dockerImage          : [
                    'hotspot'    : 'adoptopenjdk/ubuntu2004_build_image:linux-riscv64',
                    'openj9'     : 'adoptopenjdk/centos6_build_image',
                    'bisheng'    : 'adoptopenjdk/centos6_build_image'
            ],
            dockerArgs           : [
                    'hotspot'    : '--platform linux/riscv64'
            ],
            dockerNode         : 'sw.tool.docker && sw.config.uid1000',
            dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
            crossCompile         : [
                    'hotspot'    : 'dockerhost-rise-ubuntu2204-aarch64-1',
                    'openj9'     : 'x64',
                    'bisheng'    : 'x64'
            ],
            buildArgs            : [
                    'hotspot'    : '--create-sbom',
                    'openj9'     : '--cross-compile --ssh',
                    'bisheng'    : '--cross-compile --branch risc-v'
            ],
            configureArgs        : [
                    'hotspot'    : '--enable-headless-only=yes --enable-dtrace',
                    'openj9'     : '--disable-ddr --with-cmake --openjdk-target=riscv64-unknown-linux-gnu --with-sysroot=/opt/fedora28_riscv_root',
                    'bisheng'    : '--openjdk-target=riscv64-unknown-linux-gnu --with-sysroot=/opt/fedora28_riscv_root --with-jvm-features=shenandoahgc'
            ],
            test                 : [
                    'hotspot'    : 'default',
                    'openj9'     : false,
                    'bisheng'    : [
                        nightly : ['sanity.openjdk'],
                        weekly : ['sanity.openjdk', 'sanity.system', 'extended.system', 'sanity.perf']
                    ]
            ]
        ],
    

        aarch64Mac: [
                os                  : 'mac',
                arch                : 'aarch64',
                additionalNodeLabels: [
                        openj9 : 'ci.project.openj9 && hw.arch.aarch64 && sw.os.mac',
                        temurin: 'macos11'
                ],
                cleanWorkspaceAfterBuild: true,
                configureArgs       : [
                        'openj9'    : '--enable-dtrace --disable-warnings-as-errors --with-noncompressedrefs --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                        'temurin'   : '--enable-dtrace=auto',
                        'openj9'    : '--enable-dtrace=auto',
                        'corretto'  : '--enable-dtrace=auto',
                        'dragonwell': "--enable-dtrace=auto --with-extra-cflags=\"-march=armv8.2-a+crypto\" --with-extra-cxxflags=\"-march=armv8.2-a+crypto\"",
                        'bisheng'   : '--enable-dtrace=auto --with-extra-cflags=-fstack-protector-strong --with-extra-cxxflags=-fstack-protector-strong --with-jvm-variants=server'
                ],
                buildArgs           : [
                        'temurin'   : '--create-sbom'
                ]
        ],

        riscv64Linux      :  [
                os                   : 'linux',
                arch                 : 'riscv64',
                dockerImage          : [
                        'temurin'    : 'adoptopenjdk/ubuntu2004_build_image:linux-riscv64',
                        'openj9'     : 'adoptopenjdk/centos6_build_image',
                        'bisheng'    : 'adoptopenjdk/centos6_build_image'
                ],
                dockerArgs           : [
                        'temurin'    : '--platform linux/riscv64'
                ],
                crossCompile         : [
                        'temurin'    : 'qemustatic',
                        'openj9'     : 'x64',
                        'bisheng'    : 'x64'
                ],
                buildArgs            : [
                        'temurin'    : '--create-sbom',
                        'openj9'     : '--cross-compile',
                        'bisheng'    : '--cross-compile --branch risc-v'
                ],
                configureArgs        : [
                        'temurin'    : '--enable-headless-only=yes --enable-dtrace --disable-ccache',
                        'openj9'     : '--disable-ddr --openjdk-target=riscv64-unknown-linux-gnu --with-sysroot=/opt/fedora28_riscv_root',
                        'bisheng'    : '--openjdk-target=riscv64-unknown-linux-gnu --with-sysroot=/opt/fedora28_riscv_root --with-jvm-features=shenandoahgc'
>>>>>>> abff3f6a25037eaad9c9d5924bba6e861c45db2f
                ],
                test                : [
                        openj9 : 'default'
                ],
                buildArgs           : [
                        'temurin'   : '--create-sbom',
                        'openj9'    : '--ssh'
                ]
        ],

        aarch64Windows: [
                os                  : 'windows',
                arch                : 'aarch64',
                crossCompile        : 'x64',
                additionalNodeLabels: 'win2022&&vs2019',
                test                : 'default',
                buildArgs       : [
                        'temurin'   : '--jvm-variant client,server --create-sbom --cross-compile'
                ]
        ],

        x64MacIBM    : [
            os                  : 'mac',
            arch                : 'x64',
            additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.mac.10_15',
            test                : 'default',
            configureArgs       : [
                    'openj9'      : '--enable-dtrace=auto '
            ],
            additionalFileNameTag: 'IBM',
            buildArgs : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk'
        ],

        x64LinuxIBM  : [
            os                  : 'linux',
            arch                : 'x64',
            additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
            dockerImage         : 'adoptopenjdk/centos6_build_image',
            dockerFile: [
                    'openj9'  : 'pipelines/build/dockerFiles/cuda.dockerfile'
            ],
            dockerNode          : 'sw.tool.docker && sw.config.uid1000',
            dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
            test                : [
                    nightly: [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'special.system'
                    ],
                    weekly : [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'special.openjdk',
                        'special.system',
                        'dev.functional',
                        'sanity.external',
                        'dev.external',
                        'dev.openjdk',
                        'sanity.functional.fips140_2',
                        'extended.functional.fips140_2',
                        'sanity.jck.fips140_2',
                        'extended.jck.fips140_2',
                        'special.jck.fips140_2',
                        'sanity.openjdk.fips140_2',
                        'extended.openjdk.fips140_2'                        
                    ],
                    release : [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'special.openjdk',
                        'special.system',
                        'dev.external',
                        'sanity.functional.fips140_2',
                        'extended.functional.fips140_2',
                        'sanity.jck.fips140_2',
                        'extended.jck.fips140_2',
                        'special.jck.fips140_2',
                        'sanity.openjdk.fips140_2',
                        'extended.openjdk.fips140_2'
                    ]
            ],
            configureArgs       : [
                    'openj9'      : '--disable-ccache --enable-dtrace=auto'
            ],
            additionalFileNameTag: 'IBM',
            buildArgs : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk'
        ],

        x64WindowsIBM: [
            os                  : 'windows',
            arch                : 'x64',
            additionalNodeLabels: [
                    openj9:     'ci.project.openj9 && hw.arch.x86 && sw.os.windows'
            ],
            buildArgs : [
                    openj9 : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk'
            ],
            test                : 'default',
            configureArgs       : [
                    'openj9'      : '--with-jdk-rc-name="IBM Semeru Runtime"'
            ],
            additionalFileNameTag: 'IBM'
        ],

        ppc64AixIBM    : [
            os                  : 'aix',
            arch                : 'ppc64',
            additionalNodeLabels: [
                    openj9:  'hw.arch.ppc64 && sw.os.aix.7_2'
            ],
            test                : 'default',
            additionalFileNameTag: 'IBM',
            cleanWorkspaceAfterBuild: true,
            buildArgs : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk'
        ],

        s390xLinuxIBM    : [
            os                  : 'linux',
            arch                : 's390x',
            test                : [
                    nightly: [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'special.system'
                    ],
                    weekly : [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'special.openjdk',
                        'special.system',
                        'dev.functional',
                        'sanity.external',
                        'dev.external',
                        'dev.openjdk',
                        'sanity.functional.fips140_2',
                        'extended.functional.fips140_2',
                        'sanity.jck.fips140_2',
                        'extended.jck.fips140_2',
                        'special.jck.fips140_2',
                        'sanity.openjdk.fips140_2',
                        'extended.openjdk.fips140_2'                        
                    ],
                    release : [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'special.openjdk',
                        'special.system',
                        'dev.external',
                        'sanity.functional.fips140_2',
                        'extended.functional.fips140_2',
                        'sanity.jck.fips140_2',
                        'extended.jck.fips140_2',
                        'special.jck.fips140_2',
                        'sanity.openjdk.fips140_2',
                        'extended.openjdk.fips140_2'
                    ]
            ],
            additionalNodeLabels: [
                    openj9:  'hw.arch.s390x && (sw.os.cent.7 || sw.os.rhel.7)'
            ],
            dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
            configureArgs       : '--enable-dtrace=auto',
            additionalFileNameTag: 'IBM',
            buildArgs : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk'
        ],

        ppc64leLinuxIBM    : [
            os                  : 'linux',
            arch                : 'ppc64le',
            test                : [
                    nightly: [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'special.system'
                    ],
                    weekly : [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'special.openjdk',
                        'special.system',
                        'dev.functional',
                        'sanity.external',
                        'dev.external',
                        'dev.openjdk',
                        'sanity.functional.fips140_2',
                        'extended.functional.fips140_2',
                        'sanity.jck.fips140_2',
                        'extended.jck.fips140_2',
                        'special.jck.fips140_2',
                        'sanity.openjdk.fips140_2',
                        'extended.openjdk.fips140_2'                        
                    ],
                    release : [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'special.openjdk',
                        'special.system',
                        'dev.external',
                        'sanity.functional.fips140_2',
                        'extended.functional.fips140_2',
                        'sanity.jck.fips140_2',
                        'extended.jck.fips140_2',
                        'special.jck.fips140_2',
                        'sanity.openjdk.fips140_2',
                        'extended.openjdk.fips140_2'
                    ]
            ],
            additionalNodeLabels: [
                    openj9:  'hw.arch.ppc64le && (sw.os.cent.7 || sw.os.rhel.7)'
            ],
            dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
            configureArgs       : [
                        'openj9'      : '--enable-dtrace=auto'
            ],
            additionalFileNameTag: 'IBM',
            buildArgs : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk'
        ],

        aarch64LinuxIBM    : [
            os                  : 'linux',
            arch                : 'aarch64',
            dockerImage         : 'adoptopenjdk/centos7_build_image',
            dockerNode         : 'sw.tool.docker',
            dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
            additionalNodeLabels: [
                    openj9:  'hw.arch.aarch64 && sw.os.linux'
            ],
            test                : [
                    nightly: [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'special.system'
                    ],
                    weekly : [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'special.openjdk',
                        'special.system',
                        'dev.functional',
                        'sanity.external',
                        'dev.external',
                        'dev.openjdk'                        
                    ],
                    release : [
                        'sanity.functional',
                        'sanity.openjdk',
                        'sanity.perf',
                        'sanity.jck',
                        'sanity.system',
                        'extended.functional',
                        'extended.openjdk',
                        'extended.perf',
                        'extended.jck',
                        'extended.system',
                        'special.functional',
                        'special.jck',
                        'special.openjdk',
                        'special.system',
                        'dev.external'
                    ]
            ],
            configureArgs       : [
                    'temurin' : '--enable-dtrace=auto',
                    'openj9' : '--enable-dtrace=auto  --without-version-opt',
                    'corretto' : '--enable-dtrace=auto',
                    'dragonwell' : '--enable-dtrace=auto --with-extra-cflags=\"-march=armv8.2-a+crypto\" --with-extra-cxxflags=\"-march=armv8.2-a+crypto\"',
                    'bisheng' : '--enable-dtrace=auto --with-extra-cflags=-fstack-protector-strong --with-extra-cxxflags=-fstack-protector-strong --with-jvm-variants=server'
            ],
            additionalFileNameTag: 'IBM',
            buildArgs : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk'
        ],

        aarch64MacIBM: [
                os                  : 'mac',
                arch                : 'aarch64',
                additionalNodeLabels: [
                        openj9 : 'ci.project.openj9 && hw.arch.aarch64 && sw.os.mac'
                ],
                cleanWorkspaceAfterBuild: true,
                configureArgs       : [
                        openj9      : '--enable-dtrace --disable-warnings-as-errors --with-noncompressedrefs'
                ],
                test                : 'default',
                additionalFileNameTag: 'IBM',
                buildArgs : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm_sdk'
        ]
  ]

}

Config11 config = new Config11()
return config.buildConfigurations
