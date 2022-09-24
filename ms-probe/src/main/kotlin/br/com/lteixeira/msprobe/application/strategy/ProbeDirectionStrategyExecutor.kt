package br.com.lteixeira.msprobe.application.strategy

import br.com.lteixeira.msprobe.application.enumeration.Command
import br.com.lteixeira.msprobe.domain.AddProbeCommandDomain
import org.springframework.stereotype.Component

@Component
class ProbeDirectionStrategyExecutor {
    fun execute(probe: AddProbeCommandDomain): AddProbeCommandDomain {
        return probe.command.toCharArray()
            .map { cmd -> getStrategy(cmd).getDirection(probe) }
            .first()
    }

    private fun getStrategy(cmd: Char): ProbeDirectionStrategy {
        return when(Command.fromKey(cmd)) {
            Command.LEFT -> ProbeLeftDirectionStrategyImpl()
            Command.RIGHT -> ProbeRightDirectionStrategyImpl()
            Command.MOVE -> ProbeForwardDirectionStrategyImpl()
        }
    }
}