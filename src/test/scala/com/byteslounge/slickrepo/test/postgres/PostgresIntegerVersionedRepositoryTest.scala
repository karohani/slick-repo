package com.byteslounge.slickrepo.test.postgres

import com.byteslounge.slickrepo.test.{IntegerVersionedRepositoryAutoPkTest, PostgresConfig}

class PostgresIntegerVersionedRepositoryTest extends IntegerVersionedRepositoryAutoPkTest(PostgresConfig.config)
