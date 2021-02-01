/*
 *  ******************************************************************************
 *  *
 *  *
 *  * This program and the accompanying materials are made available under the
 *  * terms of the Apache License, Version 2.0 which is available at
 *  * https://www.apache.org/licenses/LICENSE-2.0.
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  * License for the specific language governing permissions and limitations
 *  * under the License.
 *  *
 *  * SPDX-License-Identifier: Apache-2.0
 *  *****************************************************************************
 */

package org.deeplearning4j.rl4j.mdp.gym;


import org.deeplearning4j.rl4j.space.DiscreteSpace;
import org.deeplearning4j.rl4j.space.HighLowDiscrete;

/**
 * @author rubenfiszel (ruben.fiszel@epfl.ch) on 7/28/16.
 *
 * this can be used to convert the discrete domain (1 action by step)
 * into the HighLow from Gym
 */

public class ActionTransformer extends DiscreteSpace {

    final private int[] availableAction;
    final private HighLowDiscrete hld;

    public ActionTransformer(HighLowDiscrete hld, int[] availableAction) {
        super(availableAction.length);
        this.hld = hld;
        this.availableAction = availableAction;
    }

    @Override
    public Object encode(Integer a) {
        return hld.encode(availableAction[a]);
    }
}
