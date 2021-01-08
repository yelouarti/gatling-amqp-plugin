package de.db.sus.test.gatling

import de.db.sus.test.gatling.amqp.request.AmqpProtocolMessage
import io.gatling.core.check.Check
import de.db.sus.test.gatling.amqp.request.AmqpProtocolMessage

package object amqp {
  type AmqpCheck = Check[AmqpProtocolMessage]
}
