class Config24 {

    final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac    : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels: [
                        openj9      : 'ci.project.openj9 && hw.arch.x86 && sw.os.mac && sw.tool.xcode.15_2',
                        temurin     : 'xcode15.0.1'
                ],
                additionalTestLabels: [
                        openj9      : '',
                        temurin     : '!sw.os.osx.10_14'
                ],
                test                : 'default',
                configureArgs       : [
                        openj9      : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                        temurin     : '--enable-dtrace'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        x64Linux  : [
                os                  : 'linux',
                arch                : 'x64',
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                dockerFile: [
                        openj9      : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                dockerNode          : 'sw.tool.docker',
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
                                'dev.openjdk',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2',
                                'extended.functional.fips140_3_OpenJCEPlusFIPS',
                                'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                                'extended.jck.fips140_3_OpenJCEPlusFIPS',
                                'special.jck.fips140_3_OpenJCEPlusFIPS',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
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
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ]
                ],
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9      : 'hw.arch.x86 && sw.os.linux'
                ],
                additionalTestLabels: [
                        openj9      : '!(sw.os.cent.6||sw.os.rhel.6)',
                        temurin     : '!(centos6||rhel6)'
                ],
                configureArgs       : [
                        'openj9'    : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                        ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        x64Windows: [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: [
                        openj9      : 'hw.arch.x86 && sw.os.windows',
                        temurin     : 'win2022&&vs2022'
                ],
                cleanWorkspaceAfterBuild: true,
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
                                'extended.functional.fips140_3_OpenJCEPlusFIPS',
                                'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                                'extended.jck.fips140_3_OpenJCEPlusFIPS',
                                'special.jck.fips140_3_OpenJCEPlusFIPS',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
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
                                'special.system'
                        ]
            ],
                configureArgs       : [
                        openj9      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-jdk-rc-name="IBM Semeru Runtime"',
                        temurin     : "--with-ucrt-dll-dir='C:/progra~2/wi3cf2~1/10/Redist/10.0.22621.0/ucrt/DLLs/x64'"
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        ppc64Aix    : [
                os                  : 'aix',
                arch                : 'ppc64',
                additionalNodeLabels: [
                        temurin: 'openxl17&&aix720',
                        openj9:  'hw.arch.ppc64 && sw.os.aix.7_2 && sw.tool.c++runtime.16_1'
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
                                'extended.functional.fips140_3_OpenJCEPlusFIPS',
                                'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                                'extended.jck.fips140_3_OpenJCEPlusFIPS',
                                'special.jck.fips140_3_OpenJCEPlusFIPS',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
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
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ]
                ],
                additionalTestLabels: [
                        temurin      : 'sw.os.aix.7_2TL5'
                ],
                cleanWorkspaceAfterBuild: true,
                configureArgs       : [
                        openj9      : '--disable-ccache --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        s390xLinux    : [
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
                                'dev.openjdk',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2',
                                'extended.functional.fips140_3_OpenJCEPlusFIPS',
                                'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                                'extended.jck.fips140_3_OpenJCEPlusFIPS',
                                'special.jck.fips140_3_OpenJCEPlusFIPS',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
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
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ]
                ],
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9:  'ci.project.openj9 && hw.arch.s390x'
                ],
                dockerImage: 'sys-rt-docker-local/semeru/s390_rhel7_build_image',
                dockerRegistry: 'https://docker-na.artifactory.swg-devops.com/',
                dockerCredential : '7c1c2c28-650f-49e0-afd1-ca6b60479546',
                dockerNode : 'sw.tool.docker',
                configureArgs       : [
                        openj9      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        ppc64leLinux    : [
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
                                'dev.openjdk',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2',
                                'extended.functional.fips140_3_OpenJCEPlusFIPS',
                                'sanity.jck.fips140_3_OpenJCEPlusFIPS',
                                'extended.jck.fips140_3_OpenJCEPlusFIPS',
                                'special.jck.fips140_3_OpenJCEPlusFIPS',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
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
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2',
                                'sanity.openjdk.fips140_3_OpenJCEPlusFIPS',
                                'extended.openjdk.fips140_3_OpenJCEPlusFIPS'
                        ]
                ],
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9      : 'ci.project.openj9 && hw.arch.ppc64le && sw.os.linux'
                ],
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                dockerFile: [
                    openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                dockerNode         : 'sw.tool.docker',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                configureArgs       : [
                        'openj9'    : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        aarch64Linux    : [
                os                  : 'linux',
                arch                : 'aarch64',
                additionalNodeLabels: [
                        openj9      : 'hw.arch.aarch64 && sw.os.linux'
                ],
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                dockerNode          : 'sw.tool.docker',
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
                                'special.system'
                        ]
                ],
                configureArgs : [
                        'openj9'    : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                        ],
                cleanWorkspaceAfterBuild: true,
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        aarch64Mac: [
                os                  : 'mac',
                arch                : 'aarch64',
                additionalNodeLabels: [
                        openj9      : 'ci.project.openj9 && hw.arch.aarch64 && sw.os.mac && sw.tool.xcode.15_2',
                        temurin     : 'xcode15.0.1'
                ],
                cleanWorkspaceAfterBuild: true,
                test                : 'default',
                configureArgs       : [
                        openj9      : '--enable-dtrace --disable-warnings-as-errors --with-noncompressedrefs --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image --ssh'
                        ]
        ],

        riscv64Linux      :  [
                os                  : 'linux',
                arch                : 'riscv64',
                crossCompile        : 'qemustatic',
                dockerImage         : 'adoptopenjdk/ubuntu2004_build_image:linux-riscv64',
                dockerArgs          : '--platform linux/riscv64',
                test                : 'default',
                configureArgs       : '--enable-headless-only=yes --enable-dtrace',
                buildArgs           : [
                        ]
        ]
  ]

}

Config24 config = new Config24()
return config.buildConfigurations
