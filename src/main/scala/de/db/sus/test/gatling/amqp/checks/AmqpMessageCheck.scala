package de.db.sus.test.gatling.amqp.checks

import de.db.sus.test.gatling.amqp.request.AmqpProtocolMessage

import java.util.{Map => JMap}
import io.gatling.commons.validation._
import io.gatling.core.check.CheckResult
import io.gatling.core.session.Session
import de.db.sus.test.gatling.amqp.AmqpCheck
import de.db.sus.test.gatling.amqp.request.AmqpProtocolMessage

object AmqpMessageCheck {

  private val AmqpMessageCheckFailure = "AMQP check failed".failure
}

case class AmqpMessageCheck(func: AmqpProtocolMessage => Boolean) extends AmqpCheck {
  override def check(response: AmqpProtocolMessage, session: Session, preparedCache: JMap[Any, Any]): Validation[CheckResult] =
    if (func(response)) {
      CheckResult.NoopCheckResultSuccess
    } else {
      AmqpMessageCheck.AmqpMessageCheckFailure
    }
}
