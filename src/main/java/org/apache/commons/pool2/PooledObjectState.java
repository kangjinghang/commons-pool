/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.pool2;

/**
 * Provides all possible states of a {@link PooledObject}.
 *
 * @since 2.0
 */
public enum PooledObjectState {

    /**
     * In the queue, not in use. 在空闲队列中,还未被使用
     */
    IDLE,

    /**
     * In use. 使用中
     */
    ALLOCATED,

    /**
     * In the queue, currently being tested for possible eviction.  在空闲队列中，当前正在测试是否满足被驱逐的条件
     */
    EVICTION,

    /**
     * Not in the queue, currently being tested for possible eviction. An attempt to borrow the object was made while
     * being tested which removed it from the queue. It should be returned to the head of the queue once eviction
     * testing completes. 不在空闲队列中，目前正在测试是否可能被驱逐。因为在测试过程中，试图借用对象，并将其从队列中删除。回收测试完成后，它应该被返回到队列的头部。
     * <p>
     * TODO: Consider allocating object and ignoring the result of the eviction test.
     * </p>
     */
    EVICTION_RETURN_TO_HEAD,

    /**
     * In the queue, currently being validated. 在队列中，正在被校验
     */
    VALIDATION,

    /**
     * Not in queue, currently being validated. The object was borrowed while being validated and since testOnBorrow was
     * configured, it was removed from the queue and pre-allocated. It should be allocated once validation completes.
     */ // 不在队列中，当前正在验证。该对象在验证时被借用，由于配置了testOnBorrow，所以将其从队列中删除并预先分配。一旦验证完成，就应该分配它。
    VALIDATION_PREALLOCATED,

    /**
     * Not in queue, currently being validated. An attempt to borrow the object was made while previously being tested
     * for eviction which removed it from the queue. It should be returned to the head of the queue once validation
     * completes. 不在队列中，当前正在验证。在之前测试是否将该对象从队列中移除时，曾尝试借用该对象。一旦验证完成，它应该被返回到队列的头部。
     */
    VALIDATION_RETURN_TO_HEAD,

    /**
     * Failed maintenance (e.g. eviction test or validation) and will be / has been destroyed 无效状态(如驱逐测试或验证)，并将/已被销毁
     */
    INVALID,

    /**
     * Deemed abandoned, to be invalidated. 判定为无效,将会被设置为废弃
     */
    ABANDONED,

    /**
     * Returning to the pool. 正在使用完毕,返回池中
     */
    RETURNING
}
