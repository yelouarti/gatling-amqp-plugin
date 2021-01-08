package de.db.sus.test.gatling.amqp

import com.rabbitmq.client.ConnectionFactory
import de.db.sus.test.gatling.amqp.checks.AmqpCheckSupport
import de.db.sus.test.gatling.amqp.protocol.{AmqpProtocol, AmqpProtocolBuilder, AmqpProtocolBuilderBase, RabbitMQConnectionFactoryBuilder}
import de.db.sus.test.gatling.amqp.request.{AmqpDslBuilderBase, PublishDslBuilder, RequestReplyDslBuilder}
import io.gatling.core.action.builder.ActionBuilder
import io.gatling.core.config.GatlingConfiguration
import io.gatling.core.session.Expression
import de.db.sus.test.gatling.amqp.protocol._

trait AmqpDsl extends AmqpCheckSupport {
  def amqp(implicit configuration: GatlingConfiguration): AmqpProtocolBuilderBase.type = AmqpProtocolBuilderBase

  def amqp(requestName: Expression[String]) = AmqpDslBuilderBase(requestName)

  def rabbitmq(implicit configuration: GatlingConfiguration): RabbitMQConnectionFactoryBuilderBase.type =
    RabbitMQConnectionFactoryBuilderBase

  implicit def amqpProtocolBuilder2amqpProtocol(builder: AmqpProtocolBuilder): AmqpProtocol = builder.build

  implicit def amqpPublishDslBuilder2ActionBuilder(builder: PublishDslBuilder): ActionBuilder = builder.build()

  implicit def amqpRequestReplyDslBuilder2ActionBuilder(builder: RequestReplyDslBuilder): ActionBuilder = builder.build()

  implicit def rabbitMQ2ConnectionFactory(builder: RabbitMQConnectionFactoryBuilder): ConnectionFactory = builder.build
}
