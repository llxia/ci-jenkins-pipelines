class Config21 {

    final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac    : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels: [
                        openj9      : 'hw.arch.x86 && sw.os.mac.10_15',
                        temurin     : 'macos10.14'
                ],
                additionalTestLabels: [
                        openj9      : '!sw.os.mac.10_11'
                ],
                test                : 'default',
                configureArgs       : [
                        openj9      : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                        temurin     : '--enable-dtrace'
                ],
                reproducibleCompare : [
                        'temurin'   : true
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image',
                        'temurin'   : '--create-jre-image --create-sbom'
                ]
        ],

        x64Linux  : [
                os                  : 'linux',
                arch                : 'x64',
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                dockerFile: [
                        openj9      : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                dockerNode          : 'sw.tool.docker && sw.config.uid1000',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9      : 'hw.arch.x86 && sw.os.linux'
                ],
                reproducibleCompare : [
                        'temurin'   : true
                ],
                additionalTestLabels: [
                        openj9      : '!(sw.os.cent.6||sw.os.rhel.6)'
                ],
                configureArgs       : [
                        'openj9'    : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                        'temurin'   : '--enable-dtrace'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image',
                        'temurin'   : '--create-source-archive --create-jre-image --create-sbom'
                ]
        ],

        x64AlpineLinux  : [
                os                  : 'alpine-linux',
                arch                : 'x64',
                dockerImage         : 'adoptopenjdk/alpine3_build_image',
                test                : 'default',
                configureArgs       : '--enable-headless-only=yes',
                buildArgs           : [
                        'temurin'   : '--create-jre-image --create-sbom'
                ]
        ],

        aarch64AlpineLinux  : [
                os                  : 'alpine-linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/alpine3_build_image',
                test                : 'default',
                configureArgs       : '--enable-headless-only=yes',
                buildArgs           : [
                        'temurin'   : '--create-jre-image --create-sbom'
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
                test                : 'default',
                configureArgs       : [
                        openj9      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-jdk-rc-name="IBM Semeru Runtime"'
                ],
                reproducibleCompare : [
                        'temurin'   : true
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image',
                        'temurin'   : '--create-jre-image --create-sbom'
                ]
        ],

        ppc64Aix    : [
                os                  : 'aix',
                arch                : 'ppc64',
                additionalNodeLabels: [
                        temurin: 'xlc16&&aix720',
                        openj9:  'hw.arch.ppc64 && sw.os.aix.7_2',
                ],
                test                : 'default',
                additionalTestLabels: [
                        temurin      : 'sw.os.aix.7_2'
                ],
                cleanWorkspaceAfterBuild: true,
                configureArgs       : [
                        openj9      : '--disable-ccache --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image',
                        'temurin'   : '--create-jre-image --create-sbom'
                ]
        ],

        s390xLinux    : [
                os                  : 'linux',
                arch                : 's390x',
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9      : 'hw.arch.s390x && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs       : [
                        openj9      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                reproducibleCompare : [
                        'temurin'   : true
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image',
                        'temurin'   : '--create-jre-image --create-sbom'
                ]
        ],

        ppc64leLinux    : [
                os                  : 'linux',
                arch                : 'ppc64le',
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9      : 'hw.arch.ppc64le && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                reproducibleCompare : [
                        'temurin'   : true
                ],
                configureArgs       : [
                        'openj9'    : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image',
                        'temurin'   : '--create-jre-image --create-sbom'
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
                test                : 'default',
                configureArgs : [
                        'openj9'    : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                        'temurin'   : '--enable-dtrace'
                ],
                cleanWorkspaceAfterBuild: true,
                reproducibleCompare : [
                        'temurin'   : true
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image',
                        'temurin'   : '--create-jre-image --create-sbom'
                ]
        ],

        aarch64Mac: [
                os                  : 'mac',
                arch                : 'aarch64',
                additionalNodeLabels: [
                        openj9      : 'hw.arch.aarch64 && sw.os.mac',
                        temurin     : 'macos11'
                ],
                cleanWorkspaceAfterBuild: true,
                test                : 'default',
                configureArgs       : [
                        openj9      : '--enable-dtrace --disable-warnings-as-errors --with-noncompressedrefs --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                reproducibleCompare : [
                        'temurin'   : true
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image',
                        'temurin'   : '--create-jre-image --create-sbom'
                ]
        ],

        arm32Linux    : [
                os                  : 'linux',
                arch                : 'arm',
                crossCompile        : 'aarch64',
                dockerImage         : 'adoptopenjdk/ubuntu1604_build_image',
                dockerArgs          : '--platform linux/arm/v7',
                test                : 'default',
                configureArgs       : '--enable-dtrace',
                buildArgs           : [
                        'temurin'   : '--create-jre-image --create-sbom'
                ]
        ],

        riscv64Linux      :  [
                os                  : 'linux',
                arch                : 'riscv64',
                test                : 'default',
                configureArgs       : '--enable-dtrace',
                buildArgs           : [
                        'temurin'   : '--create-jre-image --create-sbom'
                ]
        ],

        aarch64Windows: [
                os                  : 'windows',
                arch                : 'aarch64',
                crossCompile        : 'x64',
                additionalNodeLabels: 'win2022&&vs2022',
                test                : 'default',
                buildArgs       : [
                        'temurin'   : '--create-jre-image --create-sbom --cross-compile'
                ]
        ],

        x64MacIBM    : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels: 'hw.arch.x86 && sw.os.mac.10_15',
                additionalTestLabels: '!sw.os.mac.10_11',
                test                : 'default',
                configureArgs       : '--enable-dtrace',
                additionalFileNameTag: 'IBM',
                buildArgs           : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk21 -b ibm_sdk --create-jre-image'
        ],

        x64LinuxIBM  : [
                os                  : 'linux',
                arch                : 'x64',
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                dockerFile          : 'pipelines/build/dockerFiles/cuda.dockerfile',
                dockerNode          : 'sw.tool.docker && sw.config.uid1000',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                test                : [
                        nightly: [
                                "sanity.functional",
                                "extended.functional",
                                "sanity.openjdk",
                                "sanity.perf",
                                "sanity.jck",
                                "sanity.system",
                                "special.system"
                        ],
                        weekly : [
                                "extended.openjdk",
                                "extended.perf",
                                "extended.jck",
                                "extended.system",
                                "special.functional",
                                "special.jck",
                                "sanity.external",
                                "sanity.functional.fips140_2",
                                "extended.functional.fips140_2",
                                "sanity.jck.fips140_2",
                                "extended.jck.fips140_2",
                                "special.jck.fips140_2",
                                "sanity.openjdk.fips140_2",
                                "extended.openjdk.fips140_2"
                        ]
                ],
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: 'hw.arch.x86 && sw.os.linux',
                additionalTestLabels: '!(sw.os.cent.6||sw.os.rhel.6)',
                configureArgs       : '--enable-dtrace',
                additionalFileNameTag: 'IBM',
                buildArgs           : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk21 -b ibm_sdk --create-jre-image'
        ],

        x64WindowsIBM: [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: 'hw.arch.x86 && sw.os.windows',
                cleanWorkspaceAfterBuild: true,
                test                : 'default',
                configureArgs       : '--with-jdk-rc-name="IBM Semeru Runtime"',
                additionalFileNameTag: 'IBM',
                buildArgs           : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk21 -b ibm_sdk --create-jre-image'
        ],

        ppc64AixIBM    : [
                os                  : 'aix',
                arch                : 'ppc64',
                additionalNodeLabels: 'hw.arch.ppc64 && sw.os.aix.7_2',
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                configureArgs       : '--disable-ccache',
                additionalFileNameTag: 'IBM',
                buildArgs           : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk21 -b ibm_sdk --create-jre-image'
        ],

        s390xLinuxIBM    : [
                os                  : 'linux',
                arch                : 's390x',
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: 'hw.arch.s390x && (sw.os.cent.7 || sw.os.rhel.7)',
                additionalFileNameTag: 'IBM',
                buildArgs           : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk21 -b ibm_sdk --create-jre-image'
        ],

        ppc64leLinuxIBM    : [
                os                  : 'linux',
                arch                : 'ppc64le',
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: 'hw.arch.ppc64le && (sw.os.cent.7 || sw.os.rhel.7)',
                additionalFileNameTag: 'IBM',
                buildArgs           : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk21 -b ibm_sdk --create-jre-image'
        ],

        aarch64LinuxIBM    : [
                os                  : 'linux',
                arch                : 'aarch64',
                additionalNodeLabels: 'hw.arch.aarch64 && sw.os.linux',
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                dockerNode          : 'sw.tool.docker',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                test                : 'default',
                configureArgs       : '--enable-dtrace',
                additionalFileNameTag: 'IBM',
                cleanWorkspaceAfterBuild: true,
                buildArgs           : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk21 -b ibm_sdk --create-jre-image'
        ],

        aarch64MacIBM: [
                os                  : 'mac',
                arch                : 'aarch64',
                additionalNodeLabels: 'hw.arch.aarch64 && sw.os.mac',
                cleanWorkspaceAfterBuild: true,
                test                : 'default',
                configureArgs       : '--enable-dtrace --disable-warnings-as-errors --with-noncompressedrefs',
                additionalFileNameTag: 'IBM',
                buildArgs           : '--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk21 -b ibm_sdk --create-jre-image'
        ]
  ]

}

Config21 config = new Config21()
return config.buildConfigurations
